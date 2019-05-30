package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.domain.*;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryResponseDTO;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentRequestDTO;
import rs.edu.raf.poreskauprava.domain.lsd.license.LicenseResponseDTO;
import rs.edu.raf.poreskauprava.domain.lsd.parcel.ParcelResponseDTO;
import rs.edu.raf.poreskauprava.domain.lsd.resident.ResidentResponseDTO;
import rs.edu.raf.poreskauprava.service.*;
import rs.edu.raf.poreskauprava.util.CategoryType;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Service
public class PaymentCalculationServiceImpl implements PaymentCalculationService {

    @Autowired
    private ParcelService parcelService;

    @Autowired
    private ResidentService residentService;

    @Autowired
    private TaxRateService taxRateService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private InterestRateService interestRateService;

    @Autowired
    private CategoryCoefficientService categoryCoefficientService;

    @Autowired
    private CategoryService categoryService;


    @Override
    public void calculate() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Random random = new Random();

        List<ResidentResponseDTO> residents = residentService.getAllResidents();


        for (ResidentResponseDTO resident : residents) {
            List<ParcelResponseDTO> parcels = parcelService.getAllParcelsFor(resident.getJmbg());

            double tax = 0;
            for (ParcelResponseDTO parcel : parcels) {
                List<LicenseResponseDTO> parcelLicenses = parcel.getLicenses();

                for (LicenseResponseDTO license : parcelLicenses) {
                    Category category = categoryService.findByCategoryType(CategoryType.valueOf(license.getType()));

                    CategoryCoefficient categoryCoefficient = categoryCoefficientService.findByCategory(category);

                    TaxRate taxRate = taxRateService.findByCategory(category);

                    tax += categoryCoefficient.getCoefficient() * taxRate.getPercentage() * parcel.getEstimatedValue();
                }
            }

            List<Payment> previousPayments = paymentService.findAllByIdentificator(resident.getJmbg());

            for (Payment payment : previousPayments) {
                InterestRate interestRate = interestRateService.findByYear(payment.getYear());

                if(payment.getBalance() < 0) {
                    payment.setUnpaid(payment.getUnpaid() + ((interestRate.getPercentage() * (payment.getUnpaid() - payment.getPaid())) / 100));
                    payment.setBalance(payment.getPaid() - payment.getUnpaid());
                    paymentService.save(payment);
                }
            }


            double paid = (double) random.nextInt((int) tax);

        paymentService.save(
                    PaymentRequestDTO.builder()
                            .identificator(resident.getJmbg())
                            .year(currentYear)
                            .paid(paid)
                            .unpaid(tax)
                            .balance(paid - tax)
                            .accountNumber(String.valueOf(random.nextInt(Integer.MAX_VALUE)))
                            .build()
            );
        }
    }
}

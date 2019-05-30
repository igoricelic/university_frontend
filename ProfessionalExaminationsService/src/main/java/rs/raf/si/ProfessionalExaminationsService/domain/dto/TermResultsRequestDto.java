package rs.raf.si.ProfessionalExaminationsService.domain.dto;

import java.util.Map;

public class TermResultsRequestDto {
	
	private Long termId;
	
	private Map<Long, Boolean> resultsByCandidate;
	
	public Long getTermId() {
		return termId;
	}
	
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	
	public Map<Long, Boolean> getResultsByCandidate() {
		return resultsByCandidate;
	}
	
	public void setResultsByCandidate(Map<Long, Boolean> resultsByCandidate) {
		this.resultsByCandidate = resultsByCandidate;
	}

}

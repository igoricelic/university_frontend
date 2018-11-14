<template>
    <v-dialog v-model="dialog" class="relative" persistent max-width="800">
        <v-card class="relative add-content">
        <v-btn
            fab
            small
            class="dms-top-right-x link-feel"
            @click.prevent="closeModal">
            <v-icon>close</v-icon>
        </v-btn>
        <form>
            <v-layout row justify-center>
            <v-flex md10>
                <h2>Create exam</h2>
            </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-select
                    :items="subjects"
                    name="subject"
                    label="Subject"
                    v-model="selectedSubject"
                    item-text="name"
                    ></v-select>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-select
                    :items="proffesors"
                    name="proffesor"
                    label="Proffesor"
                    v-model="selectedProffesor"
                    item-text="lastName"
                    ></v-select>
                </v-flex>
            </v-layout>
            
            <v-layout row justify-center>
                <v-flex md10>
                    <v-select
                    :items="students"
                    name="student"
                    label="Student"
                    v-model="selectedStudent"
                    item-text="index"
                    ></v-select>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-select
                    :items="schoolYears"
                    name="schoolYear"
                    label="School Yeat"
                    v-model="selectedSchoolYears"
                    item-text="schoolYear"
                    ></v-select>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-checkbox
                        :label="`Result: ${result.toString()}`"
                        v-model="result"
                    ></v-checkbox>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
            <v-flex md10>
                <v-btn color="warning" @click="save">Save</v-btn>
            </v-flex>
            </v-layout>
        </form>
        </v-card>
    </v-dialog>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      dialog: true,
      selectedSubject: {},
      selectedProffesor: {},
      selectedStudent: {},
      selectedSchoolYears: {},
      page: 1,
      size: 3,
      result: false
    };
  },
  computed: {
    ...mapGetters({
      subjects: "subjects/getSubjects",
      proffesors: "proffesors/getProffesors",
      students: "students/getStudents",
      schoolYears: "schoolYear/getSchoolYears",
      totalPages: "getTotalPages"
    })
  },
  methods: {
    closeModal() {
      this.dialog = false;
      this.$emit("close");
    },
    save() {
      let studentId = null;
      this.students.forEach(element => {
        if (element.index === this.selectedStudent) {
          studentId = element.id;
        }
      });
      let proffesorId = null;
      this.proffesors.forEach(element => {
        if (element.lastName === this.selectedProffesor) {
          proffesorId = element.id;
        }
      });
      let subjectId = null;
      this.subjects.forEach(element => {
        if (element.name === this.selectedSubject) {
          subjectId = element.id;
        }
      });
      let schoolYearId = null;
      this.schoolYears.forEach(element => {
        if (element.schoolYear === this.selectedSchoolYears) {
          schoolYearId = element.id;
        }
      });
      let createExamDto = {
        studentId: studentId,
        proffesorId: proffesorId,
        subjectId: subjectId,
        schoolYearId: schoolYearId,
        result: this.result
      };

      this.$store
        .dispatch("exams/createExam", createExamDto)
        .then(response => {
          this.$emit("close");
        })
        .catch(error => {
          console.log(error);
        });
    },
    loadData() {
      this.$store.dispatch("students/loadAll");
      this.$store.dispatch("proffesors/loadAll");
      this.$store.dispatch("subjects/loadAll");
      this.$store.dispatch("schoolYear/loadAll");
    }
  },
  mounted: function() {
    this.loadData();
  }
};
</script>

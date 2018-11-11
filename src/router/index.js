import Vue from "vue";
import Router from "vue-router";
import StudentsPage from "@/components/students/StudentsPage";
import ProffesorsPage from "@/components/proffesors/ProffesorsPage";
import SubjectsPage from "@/components/subjects/SubjectsPage";
import ExamsPage from "@/components/exams/ExamsPage";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/exams",
      name: "Exams",
      component: ExamsPage
    },
    {
      path: "/subjects",
      name: "Subjects",
      component: SubjectsPage
    },
    {
      path: "/students",
      name: "Students",
      component: StudentsPage
    },
    {
      path: "/proffesors",
      name: "Proffesors",
      component: ProffesorsPage
    }
  ]
});

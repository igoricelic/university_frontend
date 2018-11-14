import Vue from "vue";
import Vuex from "vuex";
import students from "./students";
import proffesors from "./proffesors";
import subjects from "./subjects";
import exams from "./exams";
import schoolYear from "./schoolYear";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: { students, proffesors, subjects, exams, schoolYear }
});

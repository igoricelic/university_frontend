import studentService from "@/service/student";

const state = {
  students: [],
  page: 0,
  size: 10,
  totalElements: 0,
  totalPages: 0
};

const mutations = {
  setStudents(state, students) {
    state.students = students;
  },
  setPage(state, page) {
    state.page = page;
  },
  setSize(state, size) {
    state.size = size;
  },
  setTotalElements(state, totalElements) {
    state.totalElements = totalElements;
  },
  setTotalPages(state, totalPages) {
    state.totalPages = totalPages;
  }
};

const getters = {
  getStudents: state => state.students,
  getPage: state => state.page,
  getSize: state => state.size,
  getTotalElements: state => state.totalElements,
  getTotalPages: state => state.totalPages
};

const actions = {
  loadAll({ commit }, params) {
    if (!params) params = { page: state.page, size: state.size };

    studentService.findAll(
      page => {
        commit("setStudents", page.content);
        commit("setTotalElements", page.totalElements);
        commit("setTotalPages", page.totalPages);
      },
      error => {
        commit("setError", error.message);
      },
      params
    );
  },
  createStudent({ dispatch }, student) {
    return new Promise((resolve, reject) => {
      let studentCreateDto = {
        index: student.index,
        firstName: student.firstName,
        lastName: student.lastName
      };
      studentService.save(
        response => {
          console.log(response);
          dispatch("loadAll");
          resolve(response);
        },
        error => {
          reject(error);
        },
        studentCreateDto
      );
    });
  },
  loadById({}, studentId) {
    return new Promise((resolve, reject) => {
      let param = { id: studentId };
      studentService.findById(
        response => {
          resolve(response);
        },
        error => {
          reject(error);
        },
        param
      );
    });
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

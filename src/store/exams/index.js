import examService from "@/service/exam";

const state = {
  exams: [],
  page: 0,
  size: 10,
  totalElements: 0,
  totalPages: 0
};

const mutations = {
  setExams(state, exams) {
    state.exams = exams;
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
  },
  setPageable(state, pageable) {
    state.page = pageable.page;
    state.size = pageable.size;
  }
};

const getters = {
  getExams: state => state.exams,
  getPage: state => state.page,
  getSize: state => state.size,
  getTotalElements: state => state.totalElements,
  getTotalPages: state => state.totalPages
};

const actions = {
  loadAll({ commit }) {
    let params = { page: state.page, size: state.size };

    examService.findAll(
      page => {
        commit("setExams", page.content);
        commit("setTotalElements", page.totalElements);
        commit("setTotalPages", page.totalPages);
      },
      error => {
        commit("setError", error.message);
      },
      params
    );
  },
  loadByPath({ commit }, path) {
    examService.findByPath(
      page => {
        commit("setExams", page.content);
        commit("setTotalElements", page.totalElements);
        commit("setTotalPages", page.totalPages);
      },
      error => {
        commit("setError", error.message);
      },
      path
    );
  },
  createExam({ dispatch }, exam) {
    return new Promise((resolve, reject) => {
      examService.save(
        response => {
          dispatch("loadAll");
          resolve(response);
        },
        error => {
          reject(error);
        },
        exam
      );
    });
  },
  setPageable({ commit }, pageable) {
    commit("setPageable", pageable);
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
};

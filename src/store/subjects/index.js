import subjectService from "@/service/subject";

const state = {
  subjects: [],
  page: 0,
  size: 10,
  totalElements: 0,
  totalPages: 0
};

const mutations = {
  setSubjects(state, subjects) {
    state.subjects = subjects;
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
  getSubjects: state => state.subjects,
  getPage: state => state.page,
  getSize: state => state.size,
  getTotalElements: state => state.totalElements,
  getTotalPages: state => state.totalPages
};

const actions = {
  loadAll({ commit }, params) {
    if (!params) params = { page: state.page, size: state.size };

    subjectService.findAll(
      page => {
        commit("setSubjects", page.content);
        commit("setTotalElements", page.totalElements);
        commit("setTotalPages", page.totalPages);
      },
      error => {
        commit("setError", error.message);
      },
      params
    );
  },
  setPageable({ commit }, pageable) {
    commit("setPage", pageable.page);
    commit("setSize", pageable.size);
  },
  createSubject({ dispatch }, subject) {
    return new Promise((resolve, reject) => {
      let subjectCreateDto = {
        name: subject.name,
        description: subject.description
      };
      subjectService.save(
        response => {
          console.log(response);
          dispatch("loadAll");
          resolve(response);
        },
        error => {
          reject(error);
        },
        subjectCreateDto
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

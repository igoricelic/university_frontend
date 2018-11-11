import proffesorService from "@/service/proffesor";

const state = {
  proffesors: [],
  page: 0,
  size: 10,
  totalElements: 0,
  totalPages: 0
};

const mutations = {
  setProffesors(state, proffesors) {
    state.proffesors = proffesors;
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
  getProffesors: state => state.proffesors,
  getPage: state => state.page,
  getSize: state => state.size,
  getTotalElements: state => state.totalElements,
  getTotalPages: state => state.totalPages
};

const actions = {
  loadAll({ commit }, params) {
    if (!params) params = { page: state.page, size: state.size };

    proffesorService.findAll(
      page => {
        commit("setProffesors", page.content);
        commit("setTotalElements", page.totalElements);
        commit("setTotalPages", page.totalPages);
      },
      error => {
        commit("setError", error.message);
      },
      params
    );
  },
  loadById({ dispatch }, proffesorId) {
    return new Promise((resolve, reject) => {
      let param = { id: proffesorId };
      proffesorService.findById(
        response => {
          resolve(response);
        },
        error => {
          reject(error);
        },
        param
      );
    });
  },
  createProffesor({ dispatch }, proffesor) {
    return new Promise((resolve, reject) => {
      let proffesorCreateDto = {
        firstName: proffesor.firstName,
        lastName: proffesor.lastName,
        subjects: proffesor.subjects
      };
      proffesorService.save(
        response => {
          dispatch("loadAll");
          resolve(response);
        },
        error => {
          reject(error);
        },
        proffesorCreateDto
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

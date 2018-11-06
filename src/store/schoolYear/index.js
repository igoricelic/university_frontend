import schoolYearService from '@/service/schoolYear'

const state = {
    schoolYears: []
}

const mutations = {
    setSchoolYears (state, schoolYears) {
      state.schoolYears = schoolYears
    }
}

const getters = {
    getSchoolYears: state => state.schoolYears
}

const actions = {
    loadAll({ commit }) {
        schoolYearService.findAll (
            result => {
                commit('setSchoolYears', result)
            },
            error => {
                commit('setError', error.message)
            }
        )
    }
}

export default {
    namespaced: true,
    state,
    getters,
    mutations,
    actions
}

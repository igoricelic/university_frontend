<template>
    <v-layout row justify-center>
        <v-flex md12>
            <div>
                <h1>Proffesors</h1>
                <v-tooltip left>
                <v-btn class="right" slot="activator" small fab color="orange" @click="openCreateProffesorModal">
                    <v-icon color="white">add</v-icon>
                </v-btn>
                <span>Create new proffesor</span>
                </v-tooltip>
                <v-data-table
                    :headers="headers"
                    :items="proffesors"
                    :pagination.sync="pagination"
                    :rows-per-page-items="rowPerPageItems"
                    :rows-per-page-text="rowPerPageText"
                    :no-data-text="noDataText"
                    class="elevation-1"
                >
                    <template slot="items" slot-scope="props">
                        <td class="text-xs-left">{{ props.item.firstName }}</td>
                        <td class="text-xs-left">{{ props.item.lastName }}</td>
                        <td class="text-xs-left">{{ props.item.totalSubjects }}</td>
                        <td>
                            <v-tooltip top>
                                <v-btn slot="activator" fab small color="orange" @click="openProffesorDetailsModal(props.item.id)">
                                    <v-icon color="white">school</v-icon>
                                </v-btn>
                                <span>Show details for proffesor</span>
                            </v-tooltip>
                        </td>
                    </template>
                </v-data-table>

                <create-proffesor-modal
                v-if="showCreateProffesorModal"
                @close="closeCreateProffesorModal"
                ></create-proffesor-modal>

                <proffesor-details-modal
                v-if="showProffesorDetailsModal"
                :currProffesor="currProffesor"
                @close="closeProffesorDetailsModal"
                ></proffesor-details-modal>

            </div>
        </v-flex>
    </v-layout>
</template>

<script>
import { mapGetters } from 'vuex'
import paginationMixin from '@/components/shared/PaginationMixin'
import CreateProffesorModal from './CreateProffesorModal'
import ProffesorDetailsModal from './ProffesorDetailsModal'

export default {
    mixins: [ paginationMixin ],
    components: {
        'create-proffesor-modal': CreateProffesorModal,
        'proffesor-details-modal': ProffesorDetailsModal
    },
    data () {
        return {
            headers: [
                { text: 'First Name', value: 'firstName', sortable: true },
                { text: 'Last Name', value: 'lastName', sortable: true },
                { text: 'Total subjects', value: 'totalSubjects', sortable: true },
                { text: 'Details', value: 'details', sortable: false }
            ],
            rowPerPageItems: [ 10, 25, 50 ],
            rowPerPageText: 'Proffesors per page:',
            noDataText: 'No available content',
            currProffesor: {},
            showCreateProffesorModal: false,
            showProffesorDetailsModal: false
        }
    },
    methods: {
        openCreateProffesorModal () {
            this.showCreateProffesorModal = true
            console.log(this.showCreateProffesorModal)
        },
        closeCreateProffesorModal () {
            this.showCreateProffesorModal = false
        },
        openProffesorDetailsModal (id) {
            this.$store.dispatch('1/loadById', id)
            .then(response => {
                this.currProffesor = response
                this.showProffesorDetailsModal = true
            })
            .catch(error => {
                console.log(error)
            })
        },
        closeProffesorDetailsModal () {
            this.showProffesorDetailsModal = false
        }
    },
    computed: {
      ...mapGetters('1', {
        proffesors: 'getProffesors',
      })
    },
    mounted: function () {
        this.$store.dispatch('1/loadAll')
    }
}
</script>

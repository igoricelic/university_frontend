<template>
    <v-layout row justify-center>
        <v-flex md12>
            <div>
                <h1>Students</h1>
                <v-tooltip left>
                <v-btn class="right" slot="activator" small fab color="orange" @click="openCreateStudentModal">
                    <v-icon color="white">add</v-icon>
                </v-btn>
                <span>Create new student</span>
                </v-tooltip>
                <v-data-table
                    :headers="headers"
                    :items="students"
                    :pagination.sync="pagination"
                    :rows-per-page-items="rowPerPageItems"
                    :rows-per-page-text="rowPerPageText"
                    :no-data-text="noDataText"
                    class="elevation-1"
                >
                    <template slot="items" slot-scope="props">
                        <td class="text-xs-left">{{ props.item.index }}</td>
                        <td class="text-xs-left">{{ props.item.firstName }}</td>
                        <td class="text-xs-left">{{ props.item.lastName }}</td>
                    </template>
                </v-data-table>

                <create-student-modal
                v-if="showCreateStudentModal"
                @close="closeCreateStudentModal"
                ></create-student-modal>
            </div>
        </v-flex>
    </v-layout>
</template>

<script>
import { mapGetters } from 'vuex'
import paginationMixin from '@/components/shared/PaginationMixin'
import CreateStudentModal from './CreateStudentModal'

export default {
    mixins: [ paginationMixin ],
    components: {
        'create-student-modal': CreateStudentModal
    },
    data () {
        return {
            headers: [
                { text: 'Index', value: 'index', sortable: true },
                { text: 'First Name', value: 'firstName', sortable: true },
                { text: 'Last Name', value: 'lastName', sortable: true }
            ],
            rowPerPageItems: [ 10, 25, 50 ],
            rowPerPageText: 'Students per page:',
            noDataText: 'No available content',
            showCreateStudentModal: false
        }
    },
    methods: {
        openCreateStudentModal () {
            this.showCreateStudentModal = true
            console.log(this.showCreateStudentModal)
        },
        closeCreateStudentModal () {
            this.showCreateStudentModal = false
        }
    },
    computed: {
      ...mapGetters('0', {
        students: 'getStudents',
      })
    },
    mounted: function () {
        this.$store.dispatch('0/loadAll')
    }
}
</script>

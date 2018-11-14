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
                <v-layout row>
                    <v-flex md12>
                        <v-layout>
                            <v-text-field
                            type="text"
                            @input="filter"
                            v-model="filters.index"
                            name="index"
                            label="Index"
                            prepend-icon="info"
                            clearable
                            ></v-text-field>

                            <v-text-field
                            type="text"
                            @input="filter"
                            v-model="filters.firstName"
                            name="index"
                            label="First name"
                            prepend-icon="info"
                            clearable
                            ></v-text-field>

                            <v-text-field
                            type="text"
                            @input="filter"
                            v-model="filters.lastName"
                            name="index"
                            label="Last name"
                            prepend-icon="info"
                            clearable
                            ></v-text-field>
                        </v-layout>
                    </v-flex>
                </v-layout>

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
                        <td>
                            <v-tooltip top>
                                <v-btn slot="activator" fab small color="orange" @click="openStudentDetailsModal(props.item.id)">
                                    <v-icon color="white">school</v-icon>
                                </v-btn>
                                <span>Show details for student</span>
                            </v-tooltip>
                        </td>
                    </template>
                </v-data-table>

                <create-student-modal
                v-if="showCreateStudentModal"
                @close="closeCreateStudentModal"
                ></create-student-modal>

                <student-details-modal
                v-if="showDetailsStudentModal"
                :currStudent="currStudent"
                @close="closeStudentDetailsModal"
                ></student-details-modal>
            </div>
        </v-flex>
    </v-layout>
</template>

<script>
import { mapGetters } from "vuex";
import paginationMixin from "@/components/shared/PaginationMixin";
import CreateStudentModal from "./CreateStudentModal";
import StudentDetailsModal from "./StudentDetailsModal";

export default {
  mixins: [paginationMixin],
  components: {
    "create-student-modal": CreateStudentModal,
    "student-details-modal": StudentDetailsModal
  },
  data() {
    return {
      headers: [
        { text: "Index", value: "index", sortable: true },
        { text: "First Name", value: "firstName", sortable: true },
        { text: "Last Name", value: "lastName", sortable: true },
        { text: "Details", value: "details", sortable: false }
      ],
      rowPerPageItems: [10, 25, 50],
      rowPerPageText: "Students per page:",
      noDataText: "No available content",
      showCreateStudentModal: false,
      showDetailsStudentModal: false,
      currStudent: {},
      page: 0,
      size: 10,
      filters: {
        index: "",
        firstName: "",
        lastName: ""
      }
    };
  },
  methods: {
    openCreateStudentModal() {
      this.showCreateStudentModal = true;
      console.log(this.showCreateStudentModal);
    },
    closeCreateStudentModal() {
      this.showCreateStudentModal = false;
    },
    openStudentDetailsModal(id) {
      this.$store
        .dispatch("students/loadById", id)
        .then(response => {
          this.currStudent = response;
          this.showDetailsStudentModal = true;
        })
        .catch(error => {
          console.log(error);
        });
    },
    closeStudentDetailsModal() {
      this.showDetailsStudentModal = false;
    },
    filter() {
      let params = {
        page: this.page,
        size: this.size,
        firstName: this.filters.firstName,
        lastName: this.filters.lastName,
        index: this.filters.index
      };
      this.$store.dispatch("students/loadAll", params);
    }
  },
  computed: {
    ...mapGetters("students", {
      students: "getStudents"
    })
  },
  mounted: function() {
    this.$store.dispatch("students/loadAll");
  }
};
</script>

<template>
    <v-layout row justify-center>
        <v-flex md12>
            <div>
                <h1>Exams</h1>
                <v-tooltip left>
                <v-btn class="right" slot="activator" small fab color="orange" @click="openCreateExamModal">
                    <v-icon color="white">add</v-icon>
                </v-btn>
                <span>Create new exam</span>
                </v-tooltip>
                <v-layout row>
                    <v-flex md12>
                        <v-layout>
                            <v-text-field
                            type="text"
                            @input="filter"
                            name="proffesorName"
                            label="Proffesor name"
                            prepend-icon="info"
                            clearable
                            ></v-text-field>

                            <v-menu
                                :close-on-content-click="false"
                                v-model="startIntervalDateMenu"
                                lazy
                                transition="scale-transition"
                                offset-y
                                full-width
                            >
                                <v-text-field
                                slot="activator"
                                v-model="filters.startIntervalDate"
                                label="Start interval"
                                prepend-icon="event"
                                readonly
                                clearable
                                ></v-text-field>
                                <v-date-picker v-model="filters.startIntervalDate" @input="startIntervalDateMenu = false; filter()"></v-date-picker>
                            </v-menu>

                            <v-menu
                                :close-on-content-click="false"
                                v-model="endIntervalDateMenu"
                                lazy
                                transition="scale-transition"
                                offset-y
                                full-width
                            >
                                <v-text-field
                                slot="activator"
                                v-model="filters.endIntervalDate"
                                label="End interval"
                                prepend-icon="event"
                                readonly
                                clearable
                                ></v-text-field>
                                <v-date-picker v-model="filters.endIntervalDate" @input="endIntervalDateMenu = false; filter()"></v-date-picker>
                            </v-menu>
                        </v-layout>
                    </v-flex>
                </v-layout>

                <v-data-table
                    :headers="headers"
                    :items="exams"
                    :pagination.sync="pagination"
                    :rows-per-page-items="rowPerPageItems"
                    :rows-per-page-text="rowPerPageText"
                    :no-data-text="noDataText"
                    class="elevation-1"
                >
                    <template slot="items" slot-scope="props">
                        <td class="text-xs-left">{{ props.item.studentResponseDto.index }}</td>
                        <td class="text-xs-left">{{ props.item.studentResponseDto.lastName }}</td>
                        <td class="text-xs-left">{{ props.item.schoolYear }}</td>
                        <td class="text-xs-left">{{ props.item.subject.name }}</td>
                        <td class="text-xs-left">{{ props.item.proffesor.lastName }}</td>
                        <td class="text-xs-left">{{ props.item.success }}</td>
                    </template>
                </v-data-table>

                <create-exam-modal
                v-if="showCreateExamModal"
                @close="closeCreateExamModal"
                ></create-exam-modal>
            </div>
        </v-flex>
    </v-layout>
</template>

<script>
import { mapGetters } from "vuex";
import paginationMixin from "@/components/shared/PaginationMixin";
import CreateExamModal from "./CreateExamModal";

export default {
  mixins: [paginationMixin],
  components: {
    "create-exam-modal": CreateExamModal
  },
  data() {
    return {
      headers: [
        { text: "Student index", value: "index", sortable: true },
        { text: "Student last name", value: "lastName", sortable: false },
        { text: "School year", value: "schoolYear", sortable: true },
        { text: "Subject name", value: "subjectName", sortable: false },
        {
          text: "Proffesor last name",
          value: "proffesorLastName",
          sortable: false
        },
        { text: "Result", value: "result", sortable: false }
      ],
      rowPerPageItems: [10, 25, 50],
      rowPerPageText: "Subjects per page:",
      noDataText: "No available content",
      showCreateExamModal: false,
      page: 0,
      size: 50,
      filters: {
        startIntervalDate: "",
        endIntervalDate: ""
      },
      startIntervalDateMenu: false,
      endIntervalDateMenu: false
    };
  },
  methods: {
    openCreateExamModal() {
      this.showCreateExamModal = true;
    },
    closeCreateExamModal() {
      this.loadData();
      this.showCreateExamModal = false;
    },
    loadData() {
      let pageable = { page: this.page, size: this.size };
      this.$store.dispatch("3/setPageable", pageable);
      this.$store.dispatch("3/loadAll");
    },
    filter() {
      let params = {
        dateAndTime: this.filters.startIntervalDate,
        dateAndTime: this.filters.endIntervalDate
      };
      console.log(params);
    }
  },
  computed: {
    ...mapGetters("3", {
      exams: "getExams"
    })
  },
  mounted: function() {
    this.loadData();
  }
};
</script>

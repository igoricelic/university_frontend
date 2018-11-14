<template>
    <v-layout row justify-center>
        <v-flex md12>
            <div>
                <h1>Subjects</h1>
                <v-tooltip left>
                <v-btn class="right" slot="activator" small fab color="orange" @click="openCreateSubjectModal">
                    <v-icon color="white">add</v-icon>
                </v-btn>
                <span>Create new subject</span>
                </v-tooltip>
                <v-layout row>
                    <v-flex md4>
                        <v-layout>
                            <v-text-field
                            type="text"
                            @input="filter"
                            v-model="filters.name"
                            name="name"
                            label="Name"
                            prepend-icon="info"
                            clearable
                            ></v-text-field>
                        </v-layout>
                    </v-flex>
                </v-layout>

                <v-data-table
                    :headers="headers"
                    :items="subjects"
                    :pagination.sync="pagination"
                    :rows-per-page-items="rowPerPageItems"
                    :rows-per-page-text="rowPerPageText"
                    :no-data-text="noDataText"
                    class="elevation-1"
                >
                    <template slot="items" slot-scope="props">
                        <td class="text-xs-left">{{ props.item.name }}</td>
                        <td class="text-xs-left">{{ props.item.description }}</td>
                    </template>
                </v-data-table>

                <create-subjects-modal
                v-if="showCreateSubjectModal"
                @close="closeCreateSubjectModal"
                ></create-subjects-modal>
            </div>
        </v-flex>
    </v-layout>
</template>

<script>
import { mapGetters } from "vuex";
import paginationMixin from "@/components/shared/PaginationMixin";
import CreateSubjectsModal from "./CreateSubjectsModal";

export default {
  mixins: [paginationMixin],
  components: {
    "create-subjects-modal": CreateSubjectsModal
  },
  data() {
    return {
      headers: [
        { text: "Name", value: "name", sortable: true },
        { text: "Description", value: "description", sortable: false }
      ],
      rowPerPageItems: [10, 25, 50],
      rowPerPageText: "Subjects per page:",
      noDataText: "No available content",
      showCreateSubjectModal: false,
      page: 0,
      size: 10,
      filters: {
        name: ""
      }
    };
  },
  methods: {
    openCreateSubjectModal() {
      this.showCreateSubjectModal = true;
    },
    closeCreateSubjectModal() {
      this.loadData();
      this.showCreateSubjectModal = false;
    },
    loadData() {
      let pageable = { page: this.page, size: this.size };
      this.$store.dispatch("subjects/setPageable", pageable);
      this.$store.dispatch("subjects/loadAll");
    },
    filter() {
      let params = {
        page: this.page,
        size: this.size,
        name: this.filters.name
      };
      this.$store.dispatch("subjects/loadAll", params);
    }
  },
  computed: {
    ...mapGetters("subjects", {
      subjects: "getSubjects"
    })
  },
  mounted: function() {
    this.loadData();
  }
};
</script>

<template>
    <v-dialog v-model="dialog" class="relative" persistent max-width="800">
        <v-card class="relative add-content">
        <v-btn
            fab
            small
            class="dms-top-right-x link-feel"
            @click.prevent="closeModal">
            <v-icon>close</v-icon>
        </v-btn>
        <form>
            <v-layout row justify-center>
            <v-flex md10>
                <h2>Create new proffesor</h2>
            </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="firstName"
                    v-model="proffesor.firstName"
                    label="First name"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="lastName"
                    v-model="proffesor.lastName"
                    label="Last Name"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>

            <br>
            <v-layout row justify-center>
                <v-flex md10>
                    <v-expansion-panel>
                        <v-expansion-panel-content
                            v-for="(subject,i) in subjects"
                            :key="i"
                            >
                            <div slot="header">
                                {{ subject.name }}
                            </div>
                            <v-card>
                                <v-card-text>{{ subject.description }}</v-card-text>
                                <v-btn v-if="proffesor.subjects.indexOf(subject.id) == -1" color="warning" @click="addSubject(subject.id)">Add</v-btn>
                                <v-btn v-if="proffesor.subjects.indexOf(subject.id) != -1" color="red" @click="removeSubject(subject.id)">Remove</v-btn>
                            </v-card>
                        </v-expansion-panel-content>
                    </v-expansion-panel>
                    <br>
                    <v-pagination
                        v-model="page"
                        @input="changePage"
                        color="warning"
                        :length="totalPages"
                    ></v-pagination>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
            <v-flex md10>
                <v-btn color="warning" @click="save">Save</v-btn>
            </v-flex>
            </v-layout>
        </form>
        </v-card>
    </v-dialog>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      dialog: true,
      proffesor: {
        firstName: "",
        lastName: "",
        subjects: []
      },
      page: 1,
      size: 3
    };
  },
  computed: {
    ...mapGetters("subjects", {
      subjects: "getSubjects",
      totalPages: "getTotalPages"
    })
  },
  methods: {
    closeModal() {
      this.dialog = false;
      this.$emit("close");
    },
    save() {
      this.$store
        .dispatch("proffesors/createProffesor", this.proffesor)
        .then(response => {
          this.$emit("close");
        })
        .catch(error => {
          console.log(error);
        });
    },
    addSubject(index) {
      this.proffesor.subjects.push(index);
    },
    removeSubject(index) {
      var elPosition = this.proffesor.subjects.indexOf(index);
      if (elPosition > -1) {
        this.proffesor.subjects.splice(elPosition, 1);
      }
    },
    changePage() {
      console.log("clicked");
      this.loadData();
    },
    loadData() {
      let pageable = { page: this.page - 1, size: this.size };
      this.$store.dispatch("subjects/setPageable", pageable);
      this.$store.dispatch("subjects/loadAll");
    }
  },
  mounted: function() {
    this.loadData();
  }
};
</script>
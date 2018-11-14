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
                        <h2>Student details</h2>
                    </v-flex>
                </v-layout>

                <v-layout row justify-center>
                        <v-flex md10>
                            <v-text-field
                            name="index"
                            v-model="currStudent.index"
                            label="Index"
                            :readonly="true"
                            ></v-text-field>
                        </v-flex>
                    </v-layout>

                <v-layout row justify-center>
                        <v-flex md10>
                            <v-text-field
                            name="firstName"
                            v-model="currStudent.firstName"
                            label="First name"
                            :readonly="true"
                            ></v-text-field>
                        </v-flex>
                    </v-layout>

                    <v-layout row justify-center>
                        <v-flex md10>
                            <v-text-field
                            name="lastName"
                            v-model="currStudent.lastName"
                            label="Last name"
                            :readonly="true"
                            ></v-text-field>
                        </v-flex>
                    </v-layout>

                    <v-layout row justify-center>
                        <v-flex md10>
                            <v-data-table
                                :headers="headers"
                                :items="currStudent.exams"
                                hide-actions
                                :no-data-text="noDataText"
                                class="elevation-1"
                            >
                                <template slot="items" slot-scope="props">
                                    <td class="text-xs-left">{{ props.item.subject.name }}</td>
                                    <td class="text-xs-left">{{ props.item.proffesor.lastName }}</td>
                                    <td class="text-xs-left">{{ props.item.proffesor.firstName }}</td>
                                    <td class="text-xs-left">{{ props.item.dateTime | formatDate }}</td>
                                </template>
                            </v-data-table>
                        </v-flex>
                    </v-layout>
            </form>
        </v-card>
    </v-dialog>
</template>


<script>
export default {
  props: {
    currStudent: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      dialog: true,
      headers: [
        { text: "Subject name", value: "subjectName", sortable: true },
        { text: "Proffesor Last name", value: "lastName", sortable: true },
        { text: "Proffesor Fast name", value: "firstName", sortable: true },
        { text: "Date", value: "date", sortable: true }
      ],
      noDataText: "There are no passed exams"
    };
  },
  methods: {
    closeModal() {
      this.dialog = false;
      this.$emit("close");
    }
  },
  mounted: function() {}
};
</script>
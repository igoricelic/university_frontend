<template>
  <div id="app">
     <v-app id="inspire">
      <navbar></navbar>
      <v-content>
          <v-container fluid fill-height>
              <v-layout justify-center align-start>
                <transition enter-active-class="animated bounceInRight">
                  <router-view />
                </transition>
              </v-layout>
          </v-container>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import Navbar from '@/components/shared/NavBar'

export default {
  name: 'App',
  components: {
    'navbar': Navbar
  }
}
</script>

<style>
.red-beacon {
  background-color: red !important;
}
a {
  text-decoration: none;
  color: black;
}
button.btn {
  margin-left: 0 !important;
}
ul.list-reset, ul.flex-list-row, ul.flex-list {
  padding: 0;
  margin: 0;
  list-style-type: none;
}
ul.flex-list-row, ul.flex-list {
  display: flex;
}
ul.flex-list {
  flex-direction: column;
}
ul.tabs li {
  cursor: pointer;
  width: 33%;
  text-align: center;
}
ul.tabs li:hover {
  background-color: #DFDFDF;
}
img.fluid {
  max-height: 100%;
  max-width: 100%;
}
.overflow-hide {
  overflow: hidden;
}
.hide {
  display: none;
}
.nc-bg-color {
  background-color: #00C0EF;
}
.circle {
  border-radius: 50% !important;
}
.full-width {
  width: 100%;
}
.full-height {
  height: 100% !important;
}
.black {
  color: black !important;
}
.white {
  color: white !important;
}
.text-left {
  text-align: left !important;
}
.dms-color-text {
  color: #21A3E5;
}
.dms-bg-color {
  background-color: #21A3E5;
}
/* Router links */
.link-reset {
  text-decoration: none;
  color: inherit;
}
.r-link {
  display: flex;
  text-decoration: none;
  color: inherit;
}
.r-link:hover {
  opacity: 0.8;
}
.z-index-99999 {
  z-index: 99999;
}
.sidebar-link {
  width: 100%;
  height: 100%;
}
.sidebar-link:hover {
  background-color: rgba(0,0,0,.12);
}
.link-feel {
  cursor: pointer;
}
.link-feel:hover {
  opacity: 0.8;
}
/* Router links END */

/* Helpers */
.relative {
  position: relative;
}
.absolute {
  position: absolute;
}
.abs-top-right {
  position: absolute;
  top: 10px;
  right: 10px;
}
.abs-top-right-5 {
  position: absolute;
  top: 5px;
  right: 5px;
}
.abs-top-left {
  position: absolute;
  top: 10px;
  left: 10px;
}
.abs-bottom-right-5 {
  position: absolute;
  bottom: 5px;
  right: 5px;
}
.text-center {
  text-align: center;
}
.loader-wrapper {
  display: flex;
  justify-content: center;
}
.no-margin {
  margin: 0 !important;
}
.mt-n15 {
  margin-top: -15px;
}
.mb-n15 {
  margin-bottom: -15px;
}
.mb-n30 {
  margin-bottom: -30px;
}
.pdl-n30 {
  padding-left: 30px;
}
.pdb-n15 {
  padding-bottom: 15px;
}
/* Fleksovi */
.dis-flex {
  display: flex;
}
.flex-center {
  display: flex;
  justify-content: center;
  align-items: center;
}
.flex-sp-around {
  display: flex;
  justify-content: space-around;
}
.flex-sp-between {
  display: flex;
  justify-content: space-between;
}
.flex-col {
  display: flex;
  flex-flow: column;
}
.flex-center-col {
  display: flex;
  flex-direction: column !important;
  justify-content: center;
  align-items: center;
}
.flex-col-start {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.flex-col-sp-between,
.flex-col-sp-between-center {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.flex-col-sp-between-center {
  align-items: center;
}
/* Epg display specifics */
.epg-preview-item {
  box-sizing: border-box;
  /* padding: 10px; */
  border: 1px solid #444;
}
.epg-preview-item .item-preview {
  box-sizing: border-box;
  padding: 0 10px;
  display: flex;
  justify-content: space-between;
}
.epg-preview-item .epg-preview-item-data {
  width: 100%;
}
.content-flex-item {
  display: flex;
  padding: 0.5em;
  width: 100%;
}

/* Animations */
@keyframes glowing {
  0% { box-shadow: 0 0 -50px #00c407; }
  40% { box-shadow: 0 0 60px #c1c400; }
  60% { box-shadow: 0 0 60px #c47600; }
  100% { box-shadow: 0 0 -50px #21A3E5; }
}

.button-glow {
  animation: glowing 2500ms infinite;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}

.v-toast {
  border-radius: 0 !important;
  font-family: 'Roboto', sans-serif;
  font-weight: 500;
  font-size: 20px;
}
.v-toast-btn-clear {
  opacity: 1;
}

/*
* The following styles are auto-applied to elements with
* transition="modal" when their visibility is toggled
* by Vue.js.
*
* You can easily play with the modal transition by editing
* these styles.
*/
.dms-modal-wrapper {
  position: relative;
}
.dms-top-right-x {
  position: absolute !important;
  top: 10px;
  right: 10px;
  font-weight: bold;
  z-index: 1;
}
.dms-top-left-x {
  position: absolute;
  top: 10px;
  left: 10px;
  font-weight: bold;
  z-index: 1;
}
.dms-modal-enter {
  opacity: 0;
}
.dms-modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
.add-content {
  padding: 20px 0;
}
.light-border {
  border: 1px solid #eee;
  padding: 10px;
}
.vdatetime-input:hover {
  cursor: pointer !important;
  opacity: 0.8 !important;
}
.ctx-menu-container {
  border: none;
}
.ctx-menu {
  min-width: 200px;
}
ul.ctx-menu li {
  padding: 10px 20px;
}
ul.ctx-menu li:hover {
  cursor: pointer;
  background-color: #eee;
}
ul.ctx-menu li:not(:last-child) {
  border-bottom: 1px solid #bbb;
}

/* EpgListItem */
.epg-preview-item {
  cursor: pointer;
  overflow: hidden;
}
.epg-preview-item.show-preview:hover {
  height: 150px !important;
  z-index: 2;
}
.epg-preview-item-details {
  width: 300px;
  padding: 0;
}
.epg-preview-item-details > div {
  padding: 5px;
}
.epg-preview-item-details .epg-title {
  width: 250px;
}
.epg-preview-item-details .epg-time {
  font-size: 18px;
}
.epg-preview-item-details .delete {
  width: 25px !important;
  position: absolute;
  right: 5px;
  top: 5px;
  margin: 0;
}
</style>

<template>
    <va-modal
        v-model="state.recordingVisible"
        no-outside-dismiss
        hide-default-actions
        max-height= 100%
        max-width= 100%
        >
        <div class="recording-modal">
            <div class="modal-header">
                <va-button class="modal-btn" color=#6565ca icon="clear" @click="closeRecording"></va-button>
            </div>
        </div>

    </va-modal>
</template>

<script>
export default {

}
</script>

<style>

</style>
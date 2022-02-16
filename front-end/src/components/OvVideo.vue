<template>
	<video class="video_board" autoplay/>
</template>

<script>
export default {
	name: 'OvVideo',

	props: {
		streamManager: Object,
	},

	mounted () {
		this.streamManager.addVideoElement(this.$el);
	},
};
</script>

<style>
.video_board {
	padding : 0.4rem; 
	/* border: thick double #32a1ce; */
	border-radius: 1rem;
}

</style>

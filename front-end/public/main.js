
$(function(){
  $('#fullpage').fullpage({
		//options here
		anchors:['section1','section2','section3','section4'],
		autoScrolling:true,
		scrollHorizontally: true,
		navigation:true,
		navigationTooltips: ['A','Z','I','T'],showActiveTooltip:true,
		navigationPosition:'left',
		fitToSection: true,
		fitToSectionDelay: 1000,
		fadingEffect :false,
		controlArrows: true,
		scrollingSpeed: 1400,
		afterLoad: function(anchorLink, index){
			// console.log("현재섹션은" + index);
			// if(index==5){
			// 	alert('마지막입니다');
			// }
		},
		afterSlideLoad: function(anchorLink, index, slideAnchor, slideIndex){
			console.log("현재 슬라이d드번호는 " + slideIndex);

		},
		
	});
	
});


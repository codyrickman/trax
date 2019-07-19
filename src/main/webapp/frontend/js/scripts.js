$(".").roundSlider({
    sliderType: "min-range",
    handleShape: "round",
    width: 22, // width of the roundSlider
    radius: 100, // radius size
    value: 60 // value you want to apply
});

$("#myRange1").roundSlider({
    width: 22, // width of the roundSlider
    radius: 100, // radius size
    value: 60 // value you want to apply
});

function getSliderValue(range) {
    range.setAttribute('brightness', range.value);
    console.log(range.value);
}
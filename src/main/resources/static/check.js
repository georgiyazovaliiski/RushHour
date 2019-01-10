function check(){
    var id = $('input[type=radio]').get(0).id;
    var name1 = id.substr(0,id.length - 5);
    for (var counter = 0; counter < 18; counter++) {
        for (var i = 0; i < 5; i++) {
            var name = name1 + counter + "_" + i + "_" + counter;
            console.log(name)
            document.getElementById(name).checked = true;
        }
    }

    //PC2137_ctl00_rptrSurveyQuestion_tbxAnswer_19

    for (var i = 18; i <= 21; i++) {
        var name = "PC2137_ctl00_rptrSurveyQuestion_tbxAnswer_"+i;
        console.log(name);
        switch (i) {
            case 18:
                $('#'+name).val("More discussions!")
                break;
            case 21:
                $('#'+name).val("I don't think so")
                break;
        }
    }
}
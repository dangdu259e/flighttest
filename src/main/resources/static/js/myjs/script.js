
function change_oneway_selection() {
    const oneway_label = document.getElementById("oneway-label");
    const return_label = document.getElementById("return-label");

    oneway_label.style.background = "url('images/ics.png') no-repeat 0 -44px";
    oneway_label.style.color = "#0f62ac";

    return_label.style.background = "url('images/ics.png') no-repeat 0 -77px";
    return_label.style.color = "#333";

    document.getElementById("col-ahaft last").style.display="none";

}

function change_return_selection() {
    const oneway_label = document.getElementById("oneway-label");
    const return_label = document.getElementById("return-label");

    return_label.style.background = "url('images/ics.png') no-repeat 0 -44px";
    return_label.style.color = "#0f62ac";

    oneway_label.style.background = "url('images/ics.png') no-repeat 0 -77px";
    oneway_label.style.color = "#333";

    document.getElementById("col-ahaft last").style.display="block";

}
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var rootURL="http://localhost:8084/WebApplication3/rest/image/delete";

$('#btnDelete').click(function() {
	deleteImage();
	return false;
});

function deleteImage() {
	console.log('delete');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#myId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Wine deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteWine error');
		}
	});
}

$('#btnAdd').click(function() {
	addImage();
	return false;
});


function addImage() {
    console.log('addWine');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: "http://localhost:8084/WebApplication3/rest/image/add",
        dataType: "json",
        data: formToJSON(),
        success: function(data, textStatus, jqXHR){
            alert('Wine created successfully');
                    },
        error: function(jqXHR, textStatus, errorThrown){
            alert('addWine error: ' + textStatus);
        }
    });
}

function formToJSON() {
    return JSON.stringify({
        "id": $('#id').val(),
        "image": $('#image').val()
            });
            }
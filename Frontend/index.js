$(document).ready(function () {
    readProducts();
  });
  
  function readProducts() {
    $("#content").empty();
  
    $.ajax({
      method: "GET",
      url: "http://localhost:8080/api/productos/listar",
      //sftp://c3s24grupo10@minticloud.uis.edu.co/c3s24grupo10/WEB-INF/classes/tiendavirtual/backend/controller/ProductosController.class/api/productos/listar
      //https://minticloud.uis.edu.co/c3s24grupo10/listar
      //http://localhost:8080/api/productos/listar
      
      type: "JSON",
      contentType: "aplication/json",
      success: function (data) {
        for (var i = 0; i < data.length; i++) {
          var row = `<tr>
                              <td>${data[i].codigoproducto}</td>
                              <td>${data[i].nombre}</td>
                              <td>${data[i].fecha_de_vencimiento}</td>
                              <td>${data[i].existencias}</td>
                              <td>${data[i].costoxunidad}</td>
                              <td>
                                  <a href="javascript:editProduct(${data[i].codigoproducto})"class="btn btn-warning">Editar</a>
                                  <a href="javascript:deleteProduct(${data[i].codigoproducto})"class="btn btn-danger">Borrar</a>
                              </td>
                      </tr>`;
          $("#content").append(row);
        }
      },
    });
  }
 
  function deleteProduct(codigoproducto) {
    var conf = confirm("¿Está seguro, realmente desea eliminar el registro?");
    if (conf == true) {
      $.ajax({
        url: "http://localhost:8080/api/productos/delete/" + codigoproducto,
        method: "DELETE",
        success: function (result) {
          readProducts();
        },
        error: function (request, msg, error) {
          // handle failure
        },
      });
    }
  }
  
  function addProduct(data) {
    var product = {
      //codigoproducto: $("#title").val(),
      nombre: $("#nombre-id").val(),
      fecha_de_vencimiento: $("#vencimiento-id").val(),
      existencias: $("#exitencias-id").val(),
      costoxunidad: $("#costoxunidad-id").val()
      
    };

  
    var json = JSON.stringify(product);
 
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/api/productos/",
      data: json,
      contentType: "application/json; charset=utf-8",
      success: function (data) {
        $("#add_product").modal("hide");
        readProducts();
  
        $("#nombre-id").val("");
        $("#vencimiento-id").val("");
        $("#existencias-id").val("");
        $("#costoxunidad-id").val("");
        //$("#tipo").val("");
        location.reload();
      },
    });
  }
  
  function updateProduct() {
    // get values
    var codigoproducto = sessionStorage.getItem("codigoproducto");
    var product = {
     
      nombre: $("nombre-id").val(),
      fecha_de_vencimiento: $("#vencimiento-id").val(),
      existencias: $("#existencias-id").val(),
      costoxunidad: $("#costoxunidad-id").val(),
      
    };
  
    var json = JSON.stringify(product);
  
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/api/productos/" + codigoproducto,
      data: json,
      contentType: "application/json; charset=utf-8",
      success: function (data) {
        $("#update_product").modal("hide");
        readProducts();
      },
    });
  }
 
  function editProduct(codigoproducto) {
    $("#update_product").modal("show");
    sessionStorage.setItem("codigoproducto", codigoproducto);
  } 
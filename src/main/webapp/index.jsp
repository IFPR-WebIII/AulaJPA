<%@ page import="com.example.aulajpa.domain.entities.Veiculo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%

    List<Veiculo> veiculos = (List<Veiculo>) request.getAttribute("attr_veiculos");

%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container">

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <%for(Veiculo v: veiculos) {%>
            <tr>
                <th scope="row"><% out.print(v.getModelo()); %></th>
                <td><%= v.getProprietario().getNome() %></td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <% } %>

            </tbody>
        </table>


    </div>

</body>
</html>
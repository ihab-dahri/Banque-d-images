<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Banque d'images - Galerie personnalisée</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<header>
    <h1>Banque d'images</h1>
    <nav>
        <a class="button" href="${pageContext.request.contextPath}/">Aléatoire</a>
        <a class="button" href="${pageContext.request.contextPath}/?page=select">Personnalisé</a>
    </nav>
</header>
<main>
    <h2>Galerie personnalisée</h2>
    <form class="card" method="post" action="${pageContext.request.contextPath}/">
        <input type="hidden" name="page" value="custom">

        <label for="category">Catégorie</label>
        <select id="category" name="category" required>
            <c:forEach var="cat" items="${categories}">
                <option value="${cat}">${cat}</option>
            </c:forEach>
        </select>

        <label for="count">Nombre d'images</label>
        <input type="number" id="count" name="count" min="1" value="10" required>

        <button type="submit" class="button">Afficher</button>
    </form>
</main>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Banque d'images - ${title}</title>
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
    <h2>${title}</h2>
    <div class="gallery">
        <c:forEach var="image" items="${images}">
            <figure>
                <img src="${pageContext.request.contextPath}/${image.path}" alt="${image.name}">
                <figcaption>${image.name}</figcaption>
            </figure>
        </c:forEach>
    </div>
</main>
</body>
</html>
<!-- Entête du site -->
<header>
    <nav class="blue" role="navigation">
        <div class="nav-wrapper container">
            <a href="index.jsp" class="brand-logo hide-on-med-and-down" style="font-size: 30px;"><i class="material-icons left deep-orange-text hide-on-med-and-down">favorite</i>Fr&eacute;quence Cardiaque</a>
            
            <a href="index.jsp" class="brand-logo right hide-on-large-only" style="font-size: 30px;"><i class="material-icons left deep-orange-text hide-on-med-and-down">favorite</i>Fr&eacute;quence Cardiaque</a>
            <ul id="" class="right hide-on-med-and-down">
                <c:choose>
                    <c:when test="${sessionScope.nom != null}">
                        <li>
                            <a class="dropdown-button" data-activates="options" data-beloworigin="true">
                                <div class="chip">

                                    <img src="${sessionScope.persoimg}" alt="${sessionScope.nom}">
                                        ${sessionScope.nom} ${sessionScope.prenom}
                                </div>
                            </a>
                        </li>
                        <!-- Dropdown Structure -->
                        <ul id="options" class="dropdown-content">
                          <li><a href="graphique.jsp">Mon Activit&eacute;</a></li>
                          <li><a href="TestDossier">Mon Dossier</a></li>
                          <li><a href="compte.jsp">Mon Compte</a></li>
                          <li class="divider"></li>
                          <li><a href="Deconnexion">D&eacute;connexion</a></li>
                        </ul>
                    </ul>
                    <!-- Vue Mobile -->
                    <ul id="nav-mobile" class="side-nav">
 
          <li><div class="userView">
            <div class="background blue">
            </div>
                  <a href="#!user"><img class="circle" src="${sessionScope.persoimg}"></a>
            <a href="#!name"><span class="white-text name">${sessionScope.nom} ${sessionScope.prenom}</span></a>
            <a href="#!email"><span class="white-text email"></span></a>
          </div></li>
                        <li><a href="graphique.jsp">Mon Activit&eacute;</a></li>
                          <li><a href="TestDossier">Mon Dossier</a></li>
                          <li><a href="compte.jsp">Mon Compte</a></li>
                          <li class="divider"></li>
                          <li><a href="Deconnexion">D&eacute;connexion</a></li>
                    </ul>
                    </c:when>
                    <c:otherwise>
                        <li><a href="inscription.jsp"><i class="material-icons left">create</i>Inscription</a></li>
                        <li><a href="connexion.jsp"><i class="material-icons left">perm_identity</i>Connexion</a></li>
                    </ul>
                    <!-- Vue Mobile -->
                    <ul id="nav-mobile" class="side-nav">
                        <li><a href="inscription.jsp"><i class="material-icons left">create</i>Inscription</a></li>
                        <li><a href="connexion.jsp"><i class="material-icons left">perm_identity</i>Connexion</a></li>
                    </ul>
                    </c:otherwise>
                </c:choose>
            
            <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>
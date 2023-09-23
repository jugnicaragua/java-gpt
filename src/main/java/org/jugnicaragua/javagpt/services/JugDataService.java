package org.jugnicaragua.javagpt.services;

import com.vaadin.cdi.annotation.VaadinSessionScoped;

@VaadinSessionScoped
public class JugDataService {

    public final static String FUNCTION_MEMBER_DATA = "getMembersData";

    public String getJugMemberDataByName(String jugMemberName) {
        if (jugMemberName.trim().isEmpty()) {
            return "Debes especificar el nombre de uno de los miembros para obtenere datos";
        }

        switch (jugMemberName.trim().toLowerCase()) {
            case "omar berroteran":
            case "omar":
                return "Java Senior DevOps. Gentoo & Fedora contributor. Developer advocate. Conferencista consultor y trainer internacional en tecnologías Java, Google, Robótica y Linux.";
            case "francisco contreras":
            case "francisco":
                return "CTO en GInIEm S.A. Master en Informática Empresarial, Desarrollador de software y arquitecto de sistemas con más de 13 años de experiencia. Sr. Software Engineer en Design House, Sr. Software Engineer en Wepa, entusiasta de Java y tecnologías móviles y conferencista internacional y organizador de Flutter Nicaragua, Conferencista Internacional. Disfruta de retos y proyectos innovadores.";
            case "armando alaniz":
            case "armando":
                return "Java Senior Developer en Intertec. Experto en EE,  programación funcional, amante de SQL y los motores de base de datos relacionales";
            case "leticia herrera":
            case "leticia":
                return "CEO en Newmeros S.A. y GInIEm S.A. Master en Informática empresarial con Postgrado en finanzas corporativas. Entusiasta de las tecnologías con más de 10 años de experiencia en digitalización empresarial y automatización de procesos contables y financieros.";
            case "roberto rodriguez":
            case "roberto":
                return "Java Senior Developer, experto en GUI, procesos, facade, spring, patrones. Co-Fundador JUG-Nicaragua.";
            case "darling areas":
            case "darling":
                return "ICT Specialist UNOPS. PMP certificada. Apasionada por las buenas prácticas en dirección de proyectos e incursionando en el mundo de la Ciencia de Datos. Experiencia en proyectos de alto impacto social a nivel nacional e internacional. Amante a la lectura y enfocada a objetivos.";
            case "luis guido":
            case "luis":
                return "Experto en Mobile Stack, Kotlin, Android y mucho más.";
            case "fermando espinoza":
            case "fernando":
                return "Ingeniero de QA en Design House. Embajador de Mozilla y Fedora.";
            case "hernaldo urbina":
            case "hernaldo":
                return "Ingeniero de Software en Aviantica";
            default:
                return "No parece haber ningun miembro con ese nombre";
        }
    }

}

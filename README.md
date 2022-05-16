# DnD-CharacterManager
This Repo includes a DnD-CharacterManager project for Uni as part of the lecture Advanced Software Engineering

## Resources
* [DnD 5e Players Handbook google drive](https://drive.google.com/file/d/0Bx1CPyXhMVKYSU4xRkN3dkV4YjQ/view?resourcekey=0-svEEG_yD7O48DP8JttkErQ)
* [Players Handbook DnD Beyond](https://www.dndbeyond.com/sources/phb)
* [DnD Beyond](https://www.dndbeyond.com/)

## Angemeldeter Umfang
Mit diesem Terminal basiertem Tool soll es möglich sein Charaktere anzulegen, zu verwalten und den Spielfortschritt des Charakters abzubilden. Das ganze soll natürlich auch Regelkonform sein und dementsprechend dem offiziellem Regelwerk von D&D 5e folgen.
Dabei gilt es neben den normalen Charakterbögen des Spiels, auch die jeweiligen Klassen etc. abzubilden, sowie die verschiedenen Wege zur Charakter Erstellung. Dadurch soll es ermöglicht werden nicht nur vorhandene Charaktere anzulegen, sondern auch Charaktere zu generieren.

## Programmentwurf Anforderungen
> **Definition Programmentwurf**: Ein Programmentwurf umfasst die Bearbeitung einer Aufgabenstellung mit der Auswahl geeigneter Methoden,
der Formulierung der verwendeten Algorithmen in einer
Programmiersprache, das Testen und Überprüfen der Ergebnisse auf Richtigkeit und die Programmdokumentation.

### Praxisprojekt
* Code und schriftliche Dokumentation
* Java oder C#
* Klar definierter (sinnvoller) Nutzen -> Programm bereits genehmigt
* Keine Benutzeroberfläche
* **Keine Fremdbibliotheken**

### Bewertung
* **Siehe Dokumentations Vorlage**
* Analyse und Begründung für:
    * SOLID
    * GRASP (Kopplung und Kohäsion)
    * DRY
* Entwurfsmuster
    * \>= 2 Entwurfsmuster einsetzen und begründen
    * UML-Diagramm vorher und nachher
* Domain Driven Design
    * Analyse der Ubiquitous Language
    * Analyse und Begründung für:
        * Repositories
        * Aggregates
        * Entities
        * Value Objects
* Clean Architecture
    * Beschreibung
    * Dependency Rule
    * Schichten analysieren
* Unit Tests
    * \>= 10 Unit Tests
    * ATRIP-Regeln
    * Code Coverage
    * Einsatz von Mocks
* Refactoring
    * Code Smells identifizieren
    * >= 2 Refactorings anwenden und begründen

### Source Code
* Versionskontrolle (git)
* Vollständiges Repository abgeben (hochladen oder Link zu github
* Vollständiger Source Code
    * Kompilierbar
    * Testbar
    * Ausführbar
* *Works on any (reasonable) machine*

### Schriftliche Dokumentation
* PDF-Dokument
    * Vorlage wird bereitgestellt
* Technische Dokumentation, **keine Benutzerdokumentation**
* Enthält Ergebnisse der Analysen und Begründungen der Entscheidungen
* Beispiel-Code direkt ins Dokument einbetten
* Code-Strukturen als UML-Diagramm notieren
    * Detailgrad an die Aussage anpassen


# how do skills work
Du kann "proficient" in Skills werden. Du bekommt die Möglichkeit diese Skills zu wählen einmal über deine Klasse und zum anderen über deinen Background (Da steht dann sowas wie, wähle 3 Skills von dieser Liste)

Wenn du "proficient" bist dann kommt der Proficiency Bonus auf den Skill drauf.
Jeder Skill hat standardmäßig den Wert des zugehörigen Attribut-Modifier

Also wenn du z. B. einen Dex-Bonus von +2 hast, dann hast du alles Skills die Dex benötigen mit 2.
Wenn du in einem Proficient bist und einen Proficiency-Bonus von +3 hast dann addierst du die und bekommst eine +5


# Domain Driven Design

## Entities
* Class
* Race
* DeathSaves
* Attributes
* Inventory
* Currencys

## Value Objects
* HitDie
* Attribute Bonus
* Personality

# Aggregates
* Character
* Player
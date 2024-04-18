# Console parser of JSON files

This project is a console program written in Java that parses a list of JSON files with data from the main entity and generates statistics in the context of selected attributes.
## Description
The program is designed to analyze data presented in JSON format. It reads data from JSON files containing information about players and calculates statistics by a selected attribute, such as name, position, team, or player number.
## Requirements
- Java 8 or higher
- Maven (for building and managing dependencies)

## Arguments
- args[0]-Path to the folder with JSON files
- args[1]-Category for which statistics will be built
- args[2]-Path where to write the XML file

##  Usage
1. Build the project using Maven
2. Run the program by passing the command line arguments
3. 
## Description of classes and functionality
- `Player.java`: A class representing a player, with methods for accessing attributes and a method for selecting a category for statistics.
- `PlayerParser.java`: A class for parsing JSON files and creating player objects.
- `DirectoryReader.java`: Class for reading JSON files from the specified directory and creating a list of players.
- `StatCounter.java`: Class for calculating statistics for the selected attribute.
- `XmlWriter.java`: A class for writing statistics to an XML file.

## Streams
* using 2 streams enter 148ms
* using 4 streams enter 151ms
* using 8 streams enter 155ms

## Example of a JSON file
```json
[
{"name": "Devin Booker",
"position": "Point guard",
"team": "Phoenix Suns",
"number": 0
},
{
"name": "Zion Williamson",
"position": "Power forward",
"team": "New Orleans Pelicans",
"number": 1
},
{
"name": "Chris Paul",
"position": "Point guard",
"team": "Phoenix Suns",
"number": 3
}]
```
##Example of XML file result by team attribute
```xml
<statistics>
    <item>
        <value>Phoenix Suns</value>
        <count>2</count>
    </item>
    <item>
        <value>New Orleans Pelicans</value>
        <count>1</count>
    </item>
</statistics>

## Music Library Management System
This repository contains the implementation for a Music Library Management System, which is a Java program designed to store information about recorded music collections, similar to Apple's iTunes. The system does not include the functionality to play the songs themselves but focuses on managing information about music tracks, artists, albums, and playlists.

## Aims

The primary aim of this project is to improve knowledge and experience of applying Object Oriented Design and Implementation techniques to solving problems using the JAVA programming language. Specifically, the project aims to gain experience in the following areas:

-   Java programming environment.
-   Object-oriented programming: comments; types; variable declarations; arithmetic and Boolean expressions; assignment.
-   Loops and conditions; input and output.
-   Data structures: arrays and lists.
-   Simple algorithms: searching, sorting.
-   Methods.
-   Objects; inheritance; applications.

## Overview

The Music Library Management System consists of several Java classes that handle different aspects of music management:

-   **Artist**: A class to store information about music artists, including soloists and bands. Soloists have a name, while bands have a list of members, who may also be soloists.
-   **Track**: A class to store information about music tracks. It includes attributes such as track title, artist, date, length, rating, location of the music file (MP3), size of the music file, and optional guest artist(s). This class also provides methods to manage track information and play count.
-   **Album**: A class to represent music albums, containing an artist, title, and an ordered list of tracks. It provides methods to manage album information, such as creating albums, setting/getting album attributes, defining the list of tracks, and retrieving album statistics.
-   **MusicLibrary**: A class to represent a music library, providing methods to create a library, add tracks/albums, and create a list of tracks with the lowest rating.

## Problems Solved

### Problem: Basic I

-   Defined Java classes to store information about artists and music tracks.
-   Implemented methods to create tracks, set/get track attributes, add guest artists, manage play count, and retrieve track information.

### Problem: Basic II

-   Defined a Java class to represent albums and implemented methods to manage album information, including creating albums, setting/getting album attributes, defining the list of tracks, and retrieving album statistics.

### Problem: Basic III

-   Defined a Java class to represent a music library and provided methods to create a library, add tracks/albums, and create a list of tracks with the lowest rating.

### Extension I

-   Implemented a special type of album, the compilation album, which may or may not have an artist and can include tracks from different artists. Each track on a compilation album stores the original album it came from.


## Usage

To use the Music Library Management System, clone this repository and import it into your Java project. Then, you can utilize the provided classes to manage music tracks, artists, albums, and libraries in your application.

## Contributors

This project was developed by **Mali Revanth Reddy** for the summative assessment of [Module Name].

## License

This project is licensed under the **MIT**. See the LICENSE file for details.

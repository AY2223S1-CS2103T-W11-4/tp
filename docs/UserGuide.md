---
layout: page
title: User Guide
---
# Waddle User Guide 🦆
Waddle is a **simple, no-frills travel planning application catered to people who love doing everything on their keyboards**. Waddle allows users to plan their travels in **3 simple steps**.
1. Create a trip itinerary
2. Add activities to your itinerary
3. Make a schedule for your trip

**It's that simple**.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `Waddle.jar` from [here](https://github.com/AY2223S1-CS2103T-W11-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for Waddle.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`add d/Japan Trip c/Japan s/2023-01-04 du/14`** : Adds an itinerary for a 14-day trip to Japan named "Japan Trip".

   * **`delete`**`1` : Deletes the 1st itinerary shown in the current list.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/My Japan Trip`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [c/COUNTRY]` can be used as `n/My Japan Trip c/Japan` or as `n/My Japan Trip`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[w/WADDLERS]…​` can be used as ` ` (i.e. 0 times), `w/me`, `w/friend 1 w/friend 2` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `c/CATEGORY d/DESCRIPTION`, `d/DESCRIPTION c/CATEGORY` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `d/Eat Ramen d/Aquarium`, only `d/Aquarium` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Commands on main page

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Creating a new itinerary: `add`

Adds an itinerary to Waddle.

Format: `add n/NAME [c/COUNTRY] dur/DURATION s/START DATE [p/NUMBER OF WADDLERS]`

Examples:
* `add n/My Japan Trip d/6`
* `add n/Germanyyyy c/Germany d/14 s/05/10/22 e/19/10/22 p/4`

### Listing all itineraries : `list`

Shows a list of all itineraries in Waddle.

Format: `list`

### Editing the details of an itinerary: `edit`

Edits an existing itinerary in Waddle.

Format: `edit INDEX [n/NAME] [c/COUNTRY] [dur/DURATION] [sd/START DATE] [p/NUMBER OF WADDLERS] [b/BUDGET]`

* Edits the itinerary at the specified `INDEX`. The index refers to the index number shown in the displayed itinerary list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
* `edit 1 d/15 sd/04/10/22` Edits the duration and start date of the first itinerary to be `15` and `04/10/22` respectively.
* `edit 2 c/India` Edits the country of the second itinerary to be `India`.

### Locating itineraries by name: `find`

Finds itineraries with names containing any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `india` will match `india`
* The order of the keywords does not matter. e.g. `Trip Japan My` will match `My Japan Trip`
* Only the name is searched.
* Only full words will be matched e.g. `Jap` will not match `Japan`
* Itineraries matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Trip` will return `My Japan Trip`, `My Germany Trip`

Examples:
* `find India` returns `My India Trip` and `India Expedition`
* `find India Trip` returns `My Japan Trip`, `My India Trip`, `India Expedition`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting an itinerary : `delete`

Deletes the specified itinerary from Waddle.

Format: `delete INDEX`

* Deletes the itinerary at the specified `INDEX`.
* The index refers to the index number shown in the displayed itinerary list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd itinerary in Waddle.
* `find Japan` followed by `delete 1` deletes the 1st itinerary in the results of the `find` command.

### Clearing itineraries : `clear`

Deletes all itineraries in Waddle.

Format: `clear`

### Selecting an itinerary: `select`

Enters the planning page (link here to plan stage commands?) for the selected itinerary.

Format: `select INDEX`

Examples:
* `select 1`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Commands on planning page

### Adding an item: `add`

Adds an item to the list of items.

Format: `add d/DESCRIPTION [p/PRIORITY] [c/COST] [du/DURATION]`

### Listing all items: `list`

Shows a list of all items (both scheduled and unscheduled) related to the itinerary.

Format: `list`

### Editing the details of an item: `edit`

Edits an existing item in the item list.

Format: `edit INDEX [d/DESCRIPTION] [p/PRIORITY] [c/COST] [du/DURATION]`

* Edits the item at the specified `INDEX`. The index refers to the index number shown in the displayed item list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

### Deleting an item: `delete`

Deletes an existing item in the item list.

Format: `delete INDEX`

### Scheduling an item: `plan`

Schedules an item identified by the index number used in the item list.

Format: `plan INDEX [d/DAY NUMBER] [s/START TIME]

* The item to be scheduled must have a duration.

### Saving the data

Waddle data are saved in the hard disk automatically after any command that changes the data is used. There is no need to save manually.

### Editing the data file

Waddle data are saved as a JSON file `[JAR file location]/data/waddle.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Waddle will discard all data and start with an empty data file at the next run. Please perform a backup before manually editing data.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Waddle home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

### Home Page Commands
Action | Format, Examples
--------|------------------
**Add Itinerary** | `add d/DESCRIPTION [c/COUNTRY] du/DURATION s/START DATE [p/NUMBER OF WADDLERS] [b/BUDGET]`<br> e.g., `add n/Germanyyyy c/Germany du/14 s/2022-05-10 p/4 b/7500`
**Clear Itineraries** | `clear`
**Delete Itinerary** | `delete INDEX`<br> e.g., `delete 3`
**Edit Itinerary** | `edit INDEX [n/NAME] [c/COUNTRY] [du/DURATION] [s/START DATE] [p/NUMBER OF WADDLERS] [b/BUDGET]`<br> e.g.,`edit 1 d/15 s/2022-04-10`
**Find Itinerary** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find India Trip`
**List Itineraries** | `list`
**Help** | `help`
**Select Itinerary** | `select INDEX`<br> e.g., `select 3`

### Itinerary Page Commands
Action | Format, Examples
--------|------------------
**Add Item** | `add d/DESCRIPTION [p/PRIORITY] [c/COST] [du/DURATION]`<br> e.g.,`add d/Visit Taj Mahal p/5 c/40 du/180`
**Delete Item** | `delete INDEX`<br> e.g., `delete 3`
**Edit Item** | `edit INDEX [d/DESCRIPTION] [p/PRIORITY] [c/COST] [du/DURATION]`<br> e.g., `edit 4.1 c/50`
**Schedule Item** | `plan INDEX d/DAY NUMBER st/START TIME`<br> e.g., `plan 1 d/4 st/12:00`
**Unschedule Item** | `unplan INDEX`<br> e.g., `unplan 3.2`
**View Vacant Slots** | `free`
**Return to Home Page** | `home`
**Export to PDF** | `export`


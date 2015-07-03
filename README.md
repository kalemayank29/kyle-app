# kyle-app
Kyle's masterpeice

# Instructions for building new forms

* Create a new Android Project for every form that you want to build.
* Use Linear Layout, and the 3 column approach. Develop only in Landscape mode.
* Include Wifi permissions in the Android Manifest.xml
* Create a class whose instance will have the data from all the form fields.
* Create a clean DatabaseHandler class that will create a new table in an existing database.
* Always write a delete all and/or drop table helper function.
* Create 2 tables, one for scratch data and the other for curated data. These should be in Sync.
* Only push to the Monkey InterWeb from the curated table.
* Log.e fields before populating anything to ensure non-NULLness.

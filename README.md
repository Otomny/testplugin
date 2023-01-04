
# Testplugin

Showcase plugin to test every Minecraf-related libraries in this repo.

## GUIs

Classes that tests [gui library](https://github.com/Otomny/guis) are located here:
- src/main/java/fr/omny
  - App (Initializer for OGui to work)
  - gui/
    - TestManager (One class that hold each instance of TestObject)
      - You can add, remove or edit an object InGame, without having to reload, without having to edit a config file.
    - TestManager.TestObject (Dummy object to test each editor of the GUI lib)
  - commands/
    - GuiCommand (Open the TestManager inventory)
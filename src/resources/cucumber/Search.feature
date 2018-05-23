Feature: It should be possible to search for places at the Norwegian Meteorological Institute, http://www.yr.no

  Scenario: Locate Stockholm

    Given navigate to url
    When search for word
    Then results appear
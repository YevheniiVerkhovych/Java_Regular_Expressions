package regExp.controller;

interface RegExpContainer {

    String patternSubscriberSurname                = "^[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20}((-|\\s){1}[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20})?";
    String patternSubscriberName                   = "^[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20}((-|\\s){1}[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20})?";
    String patternSubscriberMiddleName             = "^[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20}((-|\\s){1}[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20})?";
    String patternSubscriberNickname               = "[A-Za-z0-9-\\.]{1,30}";
    String patternSubscriberComments               = "[^\\n](.){0,100}";
//  String patternSubscriberGroups                 = "";
    String patternSubscriberHomePhone              = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
    String patternSubscriberCellPhone_1            = "\\d{3}-\\d{3}-\\d\\d-\\d\\d";
    String patternSubscriberCellPhone_2            = "(\\d{3}-\\d{3}-\\d\\d-\\d\\d)??";
    String patternSubscriberEmail                  = "[A-Za-z0-9-\\.]{1,50}@[A-Za-z0-9-.]{1,50}.([A-Za-z]){2,4}";
    String patternSubscriberSkype                  = "[A-Za-z0-9-\\.]{1,30}";
    String patternSubscriberZipCode                = "\\d{5,7}";
    String patternSubscriberCity                   = "^[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20}+(-[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20})?";
    String patternSubscriberStreet                 = "^[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20}+([\\s-]?[А-ЯҐІЇЄ]{1}[а-яґіїє']{1,20})?";
    String patternSubscriberBuildingNumber         = "^\\d{1,3}[А-ЯҐІЇЄ]?[/\\d{1,3}]?";
    String patternSubscriberFlatNumber             = "\\d{1,4}";
    String patternSubscriberDateNoteCreation       = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$";
//  String patternSubscriberDateNoteLastModified   = "";
}

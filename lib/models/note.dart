class Note {
  int _id;
  String _title;
  String _description;
  String _date;
  int _priority;
  Note(this._date, this._title, this._priority, [this._description]);
  Note.withId(this._id, this._date, this._title, _priority,
      [this._description]);

  String get title => _title;
  String get description => _description;
  String get date => _date;
  int get id => _id;
  int get priority => _priority;

  set title(String t) {
    this._title = t;
  }

  set description(String t) {
    this._description = t;
  }

  set priority(int t) {
    if (t >= 1 && t <= 2) {
      this._priority = t;
    }
  }

  set date(String t) {
    this._date = t;
  }

  Map<String, dynamic> toMap() {
    var map = Map<String, dynamic>();
    map["id"] = _id;
    map["title"] = _title;
    map["description"] = _description;
    map["date"] = _date;
    map["priority"] = _priority;
    return map;
  }

  Note.fromMapObject(Map<String, dynamic> map) {
    this._priority = map["priority"];
    this._title = map["title"];
    this._id = map["id"];
    this._date = map["date"];
    this._description = map["description"];
  }
}

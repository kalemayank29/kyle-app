package com.example.kylehirschfelder.navegationdrawer;

public class Census {

    private String _caste, _pbus, _abus1, _abus2, _abus3, _wall,
                _roof, _electricity, _houseowner, _toiletuse,
                _toilet, _cook, _kitchen, _water, _date, _religion;

    private int _famid;

    public Census(int _famid, String _caste, String _religion, String _pbus,
                  String _abus1, String _abus2,
                  String _abus3,  String _wall,
                  String _roof, String _electricity, String _houseowner,
                  String _toilet, String _toiletuse, String _cook,
                  String _kitchen, String _water,
                  String _date) {

        this._famid = _famid;
        this._caste = _caste;
        this._pbus = _pbus;
        this._abus1 = _abus1;
        this._abus2 = _abus2;
        this._abus3 = _abus3;
        this._wall = _wall;
        this._roof = _roof;
        this._electricity = _electricity;
        this._houseowner = _houseowner;
        this._toiletuse = _toiletuse;
        this._toilet = _toilet;
        this._cook = _cook;
        this._kitchen = _kitchen;
        this._water = _water;
        this._date = _date;
        this._religion = _religion;
    }

    public int get_famid(){
        return _famid;
    }

    public String get_caste() {
        return _caste;
    }

    public String get_pbus() {
        return _pbus;
    }

    public String get_abus1() {
        return _abus1;
    }

    public String get_abus2() {
        return _abus2;
    }

    public String get_abus3() {
        return _abus3;
    }

    public String get_wall() {
        return _wall;
    }

    public String get_roof() {
        return _roof;
    }

    public String get_electricity() {
        return _electricity;
    }

    public String get_houseowner() {
        return _houseowner;
    }

    public String get_toiletuse() {
        return _toiletuse;
    }

    public String get_toilet() {
        return _toilet;
    }

    public String get_cook() {
        return _cook;
    }

    public String get_kitchen() {
        return _kitchen;
    }

    public String get_water() {
        return _water;
    }

    public String get_date() {
        return _date;
    }

    public String get_religion() {
        return _religion;
    }
}


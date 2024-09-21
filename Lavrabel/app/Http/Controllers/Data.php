<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\students;

class Data extends Controller
{
    function showData(){

        $data = students::all();
        return view('Pages.First', ['students' => $data]);


        
    }
}

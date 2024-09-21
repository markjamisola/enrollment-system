<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use PhpParser\Node\Stmt\Return_;
use App\Models\students;

class PagesController extends Controller
{
    public function home(){
        return view('pages.Home');
    }

    public function record(){
        // Fetch data from the database
        $data = students::all();
    
        // Loop through the fetched data
        foreach ($data as $student) {
            // Check if the enrolled field is empty or null
            if (empty($student->enrolled)) {
                // Set enrolled field to "NULL" for display in the view
                $student->enrolled = "NULL";
            }
        }
    
        // Pass the modified data to the view
        return view('pages.studentrecord', ['students' => $data]);
    }

    public function edit(students $students){
        return view('pages.edit', ['students' => $students]);
    }

    public function destroy(students $students){
        $students->delete();
        return redirect('pages.studentrecord');
    }
}

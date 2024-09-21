@extends('layouts.frontend')
@section('content')
    
    <style>
        .info{
            font-weight: bold;
        }
        .border{
            width: 70vw;
            height: 55vh;
        }
        #div{
            float: left;
            width: 30vw;
            height: 40vh;
            margin: 10px;
        }
    </style>
    <div class="container pt-5">
        <div class="border border-secondary rounded p-4">
            <label for="text" class="info" >STUDENT INFORMATION</label>
            <br>
            <div class="border border-secondary rounded p-4 gap-5" id="div">
            <p><span>Student Id : </span>{{$students['id']}}</p>
            <p><span>Student Name : </span>{{$students['name']}}</p>
            <p><span>Age : </span>{{$students['age']}}</p>
            <p><span>Address : </span>{{$students['address']}}</p>
            <p><span>Contact Number : </span>{{$students['contact']}}</p>
            <p><span>Enrolled Subject : </span>{{$students['enrolled']}}</p>
            </div>
            <div class="border border-secondary rounded p-4 " id="div">
            <label for="text">Inspiring message</label>
            <p class="pt-4">In the journey of life, challenges may arise like storms
               on the horizon, but remember, within every storm lies the
               potential for growth and transformation. Embrace the struggles
               as opportunities to strengthen your resilience, courage, and wisdom.
            </p>
            </div>
        </div>
   </div>


@endsection
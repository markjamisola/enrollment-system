@extends('layouts.frontend')
@section('content')
   
    <div class="container mt-5">
    <h1 class="text-center">DETAILS OF THE STUDENTS</h1>
    <table class="table table-responsive table-bordered border-dark table-hover text-center text-capitalized">
        <tr class="table-dark table-active text-uppercase text-white ">
            <th>Student Id</th>
            <th>Name of Student</th>
            <th>Age</th>
            <th>Address</th>
            <th>Contact Number</th>
            <th>Enrolled Subject</th>
            <th>Info</th>
            <th>Remove</th>
        </tr>
        <tbody>
        @foreach ($students as $student)
        <tr>
            <td style="text-decoration: underline">{{$student->id}}</td>
            <td>{{$student->name}}</td>
            <td>{{$student->age}}</td>
            <td>{{$student->address}}</td>
            <td>{{$student->contact}}</td>
            <td>
                @if($student->enrolled !== null)
                    {{$student->enrolled}}
                @else
                    Not Yet Enrolled
                @endif
            </td>
            <td>
                <a style="text-decoration: none; color: black;" class ="btn btn-info" href="{{ route('pages.edit', ['students' => $student->id]) }}">Info</a>
            </td>
            <td>
                <form method="post" action="{{ route('pages.destroy', ['students' => $student->id]) }}">
                    @csrf
                    @method('delete')
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
        @endforeach
        </tbody>
    </table>
    </div>
@endsection

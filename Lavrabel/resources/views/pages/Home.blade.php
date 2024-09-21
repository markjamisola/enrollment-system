@extends('Layouts.frontEnd')

@section('content')

    <style>
    .normal {
      width: 200px; /* Example original size */
      transition: width 0.5s; /* Smooth transition for resizing */
      
    }
    @keyframes glow {
    0% {
        box-shadow: 0 0 5px #32683e, 0 0 10px #dbf9e9, 0 0 15px #ff0000;
    }
    50% {
        box-shadow: 0 0 10px #c3f2cd, 0 0 20px #096a18, 0 0 30px #dbf9e9;
    }
    100% {
        box-shadow: 0 0 5px #096a18, 0 0 10px #dbf9e9, 0 0 15px #096a18;
    }
    }
    @keyframes typing {
        from { width: 0 }
        to { width: 100% }
    }
    img{
        animation: glow 2s infinite alternate;
    }
    .large {
      width: 400px; /* Example enlarged size */
      transition: width 0.5s; 
    }
    #message{
        font-weight: bold;
        overflow: hidden; /* Ensures the text is not visible until animated */
        border-right: .15em solid orange; /* Cursor effect */
        white-space: nowrap; /* Prevents line breaks */
        animation: typing 1.5s steps(20, end), blink-caret .75s;
    }
    </style>
    <h1 class="text-center pt-4">WELCOME TO OUR PROJECT</h1>
    
    <div class="container d-flex justify-content-center gap-5 align-items-center pt-5">
        <img src="frontend/1.jpg" alt="image.jpg" class="normal" id="image" > 
        <img src="frontend/2.jpg" alt="image.jpg" class="normal" id="image1" >
        <img src="frontend/3.jpg" alt="image.jpg" class="normal" id="image2" > 
    </div>
    
    <p id="message" class="text-center pt-5">We are IT-106 students in CSU and proud to showcase our skills</p>
    <script>
    
    let image =document.getElementById('image');
    let image1=document.getElementById('image1');
    let image2 =document.getElementById('image2');
    
    
    function resizeme(image){
        if(image.classList.contains('normal')){
            image.classList.add('large');
            image.classList.remove('normal');
            
        }else{
            image.classList.remove('large');
            image.classList.add('normal');
        }
    }

    let images = ['image', 'image1', 'image2'];

    images.forEach((id) => {
        const image = document.getElementById(id);
        image.addEventListener('click', function (){
            resizeme(image);
        })
    })
    </script>
    
@endsection
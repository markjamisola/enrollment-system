<!DOCTYPE html>
<he lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>
        <link rel="preconnect" href="https://fonts.bunny.net">
        <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet" />

        <link rel="stylesheet" href="{{ asset('frontend/css/bootstrap5.css') }}">
    </head>
    
    </head>
    <body>

        <div>
            @include('layouts/inc/navbar')
            @yield('content')
        </div>
        
        <script src="{{ asset('frontend/js/bootstrap5.bundle.js') }}"></script>
    </body>
</html>

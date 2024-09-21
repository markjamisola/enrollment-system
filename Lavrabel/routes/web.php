<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Data;
use App\Http\Controllers\PagesController;

Route::get('/pages.studentrecord', [PagesController::class,'record']);
Route::get('/pages/{students}/edit', [PagesController::class,'edit'])->name('pages.edit');
Route::get('/pages.Home', [PagesController::class, 'home']);
Route::delete('/pages/{students}/destroy', [PagesController::class, 'destroy'])->name('pages.destroy');





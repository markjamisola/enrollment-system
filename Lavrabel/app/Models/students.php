<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Students extends Model
{
    use HasFactory;

    // Accessor method to handle the enrolled attribute
    public function getEnrolledAttribute($value)
    {
        // Check if the enrolled data is empty or null
        if (empty($value)) {
            return "Not Yet Enrolled";
        }

        return $value;
    }
}

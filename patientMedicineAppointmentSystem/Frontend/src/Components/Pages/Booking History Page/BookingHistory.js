import React from 'react'
import './BookingHistory.css'

const BookingHistory = () => {
  return (
    <div>
 <div class="booking-card">
  <h1>Booking History</h1>

  <table class="table">
    <thead>
    <tr>
      <th>Bus Name</th>
      <th>Destination</th>
      <th>Arrival</th>
      <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>First Travels</td>
      <td>madurai</td>
      <td>chennai</td>
      <td>10/01/2024</td>
    </tr>
    </tbody>
  </table>

</div>
    </div>
  )
}

export default BookingHistory
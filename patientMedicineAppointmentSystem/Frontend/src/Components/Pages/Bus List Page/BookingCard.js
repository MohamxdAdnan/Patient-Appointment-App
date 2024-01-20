import React from 'react'
import './BookingCard.css'

const BookingCard = () => {
  return (
    <div class="booking-card">
  <div>
    <h3>Boarding &amp; Dropping</h3>
    <span></span>
</div>
    <div>
        <span>Boarding  point</span>
        <span class="gap"></span>
        <span class="right-part">Boarding time</span>
    </div>
    <div>
        <span>Dropping  point</span>
        <span class="gap"></span>
        <span class="right-part">Dropping time</span>
    </div>
    <div>
        <hr/>
        <span>Seat number</span>
        <span class="gap"></span>
        <span class="right-part">number</span>
        <hr/>
    </div>
    <div>
        <h4>Fare Details</h4>
    </div>
    <div>
        <span>Amount</span>
        <span class="gap"></span>
        <span class="right-part">Rs.amount</span>
    </div>
    <button>Book Ticket</button>
</div>
  )
}

export default BookingCard
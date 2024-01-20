import React from 'react'
import './SearchBus.css'

const SearchBus = () => {
  return (
    <div>
           <div className='home-card'>
      <form className="form" method="post">
  <div className="form-item">
    <label>From Destination</label>
    <input type="text" placeholder="Enter From Destination"/>
  </div>
  <div className="form-item">
    <label >To Destination</label>
    <input type="text" placeholder="Enter To Destination"/>
  </div>
  <div className="form-item">
    <label >Date of Travel</label>
    <input type="date"/>
  </div>
  <button>Search Bus</button>
  </form>
  </div>
    </div>
  )
}

export default SearchBus
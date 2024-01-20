import React from 'react'
import './NavBar.css'
import Home from '../Pages/Home Page/Home'
import {Link,Routes,Route} from "react-router-dom"

const NavBar = () => {
  return (
    <div>
        <ul>
        <li><Link to="/">PATIENT APPOINTMENT APP</Link></li>
            <Link className="btn btn-outline-light" to="/login">
            Login
          </Link>
          <Link className="btn btn-outline-light" to="/userprofile">
           Profile
          </Link>
           
</ul>

    </div>
  )
}

export default NavBar
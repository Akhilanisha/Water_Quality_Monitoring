import { lazy, Suspense } from 'react';
import { Route, Routes } from "react-router-dom"
import Navbar from "./Navbar"
import About from "./pages/About"
import Complaint from "./pages/Complaint"
import Home from "./pages/Home"
import Login from "./pages/Login"
import Register from "./pages/Register"
import StayAware from "./pages/StayAware"

const Admin = lazy(() => import('./pages/Admin'));

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/complaint" element={<Complaint />} />
          <Route path="/StayAware" element={<StayAware />} />
          <Route path="/Login" element={<Login />} />
          <Route
            path="/Admin"
            element={
              <Suspense fallback={<p>Loading dashboard…</p>}>
                <Admin />
              </Suspense>
            }
          />
          <Route path="/about" element={<About />} />
          <Route path="/Register" element={<Register/>}/> 
        </Routes>
      </div>
    </>
  )
}

export default App
